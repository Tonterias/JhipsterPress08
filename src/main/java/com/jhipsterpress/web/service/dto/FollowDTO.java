package com.jhipsterpress.web.service.dto;

import java.time.Instant;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Lob;

/**
 * A DTO for the Follow entity.
 */
public class FollowDTO implements Serializable {

    private Long id;

    private Instant creationDate;

    private Long cfollowedId;

    private Long cfollowingId;

    private Long followedId;

    private Long followingId;
    
    @Lob
    private byte[] cfollowingImage;
    private String cfollowingImageContentType;
    
    @Lob
    private byte[] followingImage;
    private String followingImageContentType;

    private String cfollowingCommunityname;
    
    private String followingUserFirstName;
    
    private String followingUserLastName;
    
    @Lob
    private byte[] cfollowedImage;
    private String cfollowedImageContentType;
    
    @Lob
    private byte[] followedImage;
    private String followedImageContentType;

    private String cfollowedCommunityname;
    
    private String followedUserFirstName;
    
    private String followedUserLastName;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Long getCfollowedId() {
        return cfollowedId;
    }

    public void setCfollowedId(Long communityId) {
        this.cfollowedId = communityId;
    }

    public Long getCfollowingId() {
        return cfollowingId;
    }

    public void setCfollowingId(Long communityId) {
        this.cfollowingId = communityId;
    }

    public Long getFollowedId() {
        return followedId;
    }

    public void setFollowedId(Long profileId) {
        this.followedId = profileId;
    }

    public Long getFollowingId() {
        return followingId;
    }

    public void setFollowingId(Long profileId) {
        this.followingId = profileId;
    }

	public byte[] getCfollowingImage() {
		return cfollowingImage;
	}

	public void setCfollowingImage(byte[] cfollowingImage) {
		this.cfollowingImage = cfollowingImage;
	}

	public String getCfollowingImageContentType() {
		return cfollowingImageContentType;
	}

	public void setCfollowingImageContentType(String cfollowingImageContentType) {
		this.cfollowingImageContentType = cfollowingImageContentType;
	}

	public byte[] getFollowingImage() {
		return followingImage;
	}

	public void setFollowingImage(byte[] followingImage) {
		this.followingImage = followingImage;
	}

	public String getFollowingImageContentType() {
		return followingImageContentType;
	}

	public void setFollowingImageContentType(String followingImageContentType) {
		this.followingImageContentType = followingImageContentType;
	}

	public String getCfollowingCommunityname() {
		return cfollowingCommunityname;
	}

	public void setCfollowingCommunityname(String cfollowingCommunityname) {
		this.cfollowingCommunityname = cfollowingCommunityname;
	}

	public String getFollowingUserFirstName() {
		return followingUserFirstName;
	}

	public void setFollowingUserFirstName(String followingUserFirstName) {
		this.followingUserFirstName = followingUserFirstName;
	}

	public String getFollowingUserLastName() {
		return followingUserLastName;
	}

	public void setFollowingUserLastName(String followingUserLastName) {
		this.followingUserLastName = followingUserLastName;
	}

	public byte[] getCfollowedImage() {
		return cfollowedImage;
	}

	public void setCfollowedImage(byte[] cfollowedImage) {
		this.cfollowedImage = cfollowedImage;
	}

	public String getCfollowedImageContentType() {
		return cfollowedImageContentType;
	}

	public void setCfollowedImageContentType(String cfollowedImageContentType) {
		this.cfollowedImageContentType = cfollowedImageContentType;
	}

	public byte[] getFollowedImage() {
		return followedImage;
	}

	public void setFollowedImage(byte[] followedImage) {
		this.followedImage = followedImage;
	}

	public String getFollowedImageContentType() {
		return followedImageContentType;
	}

	public void setFollowedImageContentType(String followedImageContentType) {
		this.followedImageContentType = followedImageContentType;
	}

	public String getCfollowedCommunityname() {
		return cfollowedCommunityname;
	}

	public void setCfollowedCommunityname(String cfollowedCommunityname) {
		this.cfollowedCommunityname = cfollowedCommunityname;
	}

	public String getFollowedUserFirstName() {
		return followedUserFirstName;
	}

	public void setFollowedUserFirstName(String followedUserFirstName) {
		this.followedUserFirstName = followedUserFirstName;
	}

	public String getFollowedUserLastName() {
		return followedUserLastName;
	}

	public void setFollowedUserLastName(String followedUserLastName) {
		this.followedUserLastName = followedUserLastName;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FollowDTO followDTO = (FollowDTO) o;
        if (followDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), followDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "FollowDTO [id=" + id + ", creationDate=" + creationDate + ", cfollowedId=" + cfollowedId
				+ ", cfollowingId=" + cfollowingId + ", followedId=" + followedId + ", followingId=" + followingId
				+ ", cfollowingImage=" + Arrays.toString(cfollowingImage) + ", cfollowingImageContentType="
				+ cfollowingImageContentType + ", followingImage=" + Arrays.toString(followingImage)
				+ ", followingImageContentType=" + followingImageContentType + ", cfollowingCommunityname="
				+ cfollowingCommunityname + ", followingUserFirstName=" + followingUserFirstName
				+ ", followingUserLastName=" + followingUserLastName + ", cfollowedImage="
				+ Arrays.toString(cfollowedImage) + ", cfollowedImageContentType=" + cfollowedImageContentType
				+ ", followedImage=" + Arrays.toString(followedImage) + ", followedImageContentType="
				+ followedImageContentType + ", cfollowedCommunityname=" + cfollowedCommunityname
				+ ", followedUserFirstName=" + followedUserFirstName + ", followedUserLastName=" + followedUserLastName
				+ "]";
	}
}
