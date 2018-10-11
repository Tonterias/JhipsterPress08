import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiAlertService } from 'ng-jhipster';

import { IMessage } from 'app/shared/model/message.model';
import { MessageService } from './message.service';
import { ICommunity } from 'app/shared/model/community.model';
import { CommunityService } from 'app/entities/community';
import { IProfile } from 'app/shared/model/profile.model';
import { ProfileService } from 'app/entities/profile';
import { IFollow } from 'app/shared/model/follow.model';
import { FollowService } from '../follow/follow.service';

import { Principal } from 'app/core';

@Component({
    selector: 'jhi-message-update',
    templateUrl: './message-update.component.html'
})
export class MessageUpdateComponent implements OnInit {
    private _message: IMessage;
    isSaving: boolean;

    communities: ICommunity[];

    profiles: IProfile[];
    creationDate: string;

    follows: IFollow[];

    currentAccount: any;

    constructor(
        private jhiAlertService: JhiAlertService,
        private messageService: MessageService,
        private communityService: CommunityService,
        private profileService: ProfileService,
        private followService: FollowService,
        private principal: Principal,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ message }) => {
            this.message = message;
        });
        this.principal.identity().then(account => {
            this.currentAccount = account;
//            console.log('CONSOLOG: M:ngOnInit & O: this.currentAccount : ',  this.currentAccount);
//            console.log('CONSOLOG: M:ngOnInit & O: this.owner : ',  this.owner);
            this.myMessagesCommunities();
        });
//        this.communityService.query().subscribe(
//            (res: HttpResponse<ICommunity[]>) => {
//                this.communities = res.body;
//            },
//            (res: HttpErrorResponse) => this.onError(res.message)
//        );
        this.profileService.query().subscribe(
            (res: HttpResponse<IProfile[]>) => {
                this.profiles = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.message.creationDate = moment(this.creationDate, DATE_TIME_FORMAT);
        if (this.message.id !== undefined) {
            this.subscribeToSaveResponse(this.messageService.update(this.message));
        } else {
            if (this.message.communityId !== undefined) {
                const query = {};
                query['cfollowingId.equals'] = this.message.communityId;
                this.followService
                .query(query)
                .subscribe(
                    ( res: HttpResponse<IFollow[]> ) => {
                        this.follows = res.body;
                        console.log('CONSOLOG: M:save & O: this.follows : ', this.follows);
                        this.follows.forEach(follow => {
                            if (follow.followedId !== null) {
                                this.message.profileId = follow.followedId;
                                console.log('CONSOLOG: M:save & O: this.message : ', this.message);
                                this.subscribeToSaveResponse(this.messageService.create(this.message));
                            }
                        });
                    },
                    ( res: HttpErrorResponse ) => this.onError( res.message )
                );
            } else {
                this.subscribeToSaveResponse(this.messageService.create(this.message));
            }
        }
    }

    myMessagesCommunities() {
        console.log('CONSOLOG: M:myMessagesCommunities & O: this.currentAccount : ',  this.currentAccount);
        const query = {
            };
        if ( this.currentAccount.id  != null) {
            query['userId.equals'] = this.currentAccount.id;
        }
        this.communityService
            .query(query)
            .subscribe(
                (res: HttpResponse<ICommunity[]>) => {
                    this.communities = res.body;
                    },
                (res: HttpErrorResponse) => this.onError(res.message)
            );
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IMessage>>) {
        result.subscribe((res: HttpResponse<IMessage>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackCommunityById(index: number, item: ICommunity) {
        return item.id;
    }

    trackProfileById(index: number, item: IProfile) {
        return item.id;
    }
    get message() {
        return this._message;
    }

    set message(message: IMessage) {
        this._message = message;
        this.creationDate = moment(message.creationDate).format(DATE_TIME_FORMAT);
    }
}
