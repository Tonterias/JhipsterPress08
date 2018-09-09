package com.jhipsterpress.web.service.dto;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Lob;
import com.jhipsterpress.web.domain.enumeration.Gender;
import com.jhipsterpress.web.domain.enumeration.CivilStatus;
import com.jhipsterpress.web.domain.enumeration.Gender;
import com.jhipsterpress.web.domain.enumeration.Purpose;
import com.jhipsterpress.web.domain.enumeration.Physical;
import com.jhipsterpress.web.domain.enumeration.Religion;
import com.jhipsterpress.web.domain.enumeration.EthnicGroup;
import com.jhipsterpress.web.domain.enumeration.Studies;
import com.jhipsterpress.web.domain.enumeration.Eyes;
import com.jhipsterpress.web.domain.enumeration.Smoker;
import com.jhipsterpress.web.domain.enumeration.Children;
import com.jhipsterpress.web.domain.enumeration.FutureChildren;

/**
 * A DTO for the Profile entity.
 */
public class ProfileDTO implements Serializable {

    private Long id;

    @NotNull
    private Instant creationDate;

    @Lob
    private byte[] image;
    private String imageContentType;

    @NotNull
    private Gender gender;

    @NotNull
    @Size(max = 20)
    private String phone;

    @Size(max = 7500)
    private String bio;

    private Instant birthdate;

    private CivilStatus civilStatus;

    private Gender lookingFor;

    private Purpose purpose;

    private Physical physical;

    private Religion religion;

    private EthnicGroup ethnicGroup;

    private Studies studies;

    @Min(value = -1)
    @Max(value = 20)
    private Integer sibblings;

    private Eyes eyes;

    private Smoker smoker;

    private Children children;

    private FutureChildren futureChildren;

    private Boolean pet;

    private Long userId;

    private String firstName;
    
    private String lastName;
    
    private Set<CustomActivityDTO> activities;
    
    private Set<CustomCelebDTO> celebs;
    
    private Set<CustomInterestDTO> interests;
    
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Instant getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Instant birthdate) {
        this.birthdate = birthdate;
    }

    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }

    public Gender getLookingFor() {
        return lookingFor;
    }

    public void setLookingFor(Gender lookingFor) {
        this.lookingFor = lookingFor;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public Physical getPhysical() {
        return physical;
    }

    public void setPhysical(Physical physical) {
        this.physical = physical;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public EthnicGroup getEthnicGroup() {
        return ethnicGroup;
    }

    public void setEthnicGroup(EthnicGroup ethnicGroup) {
        this.ethnicGroup = ethnicGroup;
    }

    public Studies getStudies() {
        return studies;
    }

    public void setStudies(Studies studies) {
        this.studies = studies;
    }

    public Integer getSibblings() {
        return sibblings;
    }

    public void setSibblings(Integer sibblings) {
        this.sibblings = sibblings;
    }

    public Eyes getEyes() {
        return eyes;
    }

    public void setEyes(Eyes eyes) {
        this.eyes = eyes;
    }

    public Smoker getSmoker() {
        return smoker;
    }

    public void setSmoker(Smoker smoker) {
        this.smoker = smoker;
    }

    public Children getChildren() {
        return children;
    }

    public void setChildren(Children children) {
        this.children = children;
    }

    public FutureChildren getFutureChildren() {
        return futureChildren;
    }

    public void setFutureChildren(FutureChildren futureChildren) {
        this.futureChildren = futureChildren;
    }

    public Boolean isPet() {
        return pet;
    }

    public void setPet(Boolean pet) {
        this.pet = pet;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
	
	public Set<CustomActivityDTO> getActivities() {
		return activities;
	}

	public void setActivities(Set<CustomActivityDTO> activities) {
		this.activities = activities;
	}

	public Set<CustomCelebDTO> getCelebs() {
		return celebs;
	}

	public void setCelebs(Set<CustomCelebDTO> celebs) {
		this.celebs = celebs;
	}

	public Set<CustomInterestDTO> getInterests() {
		return interests;
	}

	public void setInterests(Set<CustomInterestDTO> interests) {
		this.interests = interests;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProfileDTO profileDTO = (ProfileDTO) o;
        if (profileDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), profileDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "ProfileDTO [id=" + id + ", creationDate=" + creationDate + ", image=" + Arrays.toString(image)
				+ ", imageContentType=" + imageContentType + ", gender=" + gender + ", phone=" + phone + ", bio=" + bio
				+ ", birthdate=" + birthdate + ", civilStatus=" + civilStatus + ", lookingFor=" + lookingFor
				+ ", purpose=" + purpose + ", physical=" + physical + ", religion=" + religion + ", ethnicGroup="
				+ ethnicGroup + ", studies=" + studies + ", sibblings=" + sibblings + ", eyes=" + eyes + ", smoker="
				+ smoker + ", children=" + children + ", futureChildren=" + futureChildren + ", pet=" + pet
				+ ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", activities="
				+ activities + ", celebs=" + celebs + ", interests=" + interests + "]";
	}

}
