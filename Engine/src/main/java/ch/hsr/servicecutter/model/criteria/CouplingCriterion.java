package ch.hsr.servicecutter.model.criteria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Entity
public class CouplingCriterion {

	public static final String SEMANTIC_PROXIMITY = "Semantic Proximity";
	public static final String IDENTITY_LIFECYCLE = "Identity & Lifecycle Commonality";
	public static final String SHARED_OWNER = "Shared Owner";
	public static final String SECURITY_CONSTRAINT = "Security Constraint";
	public static final String PREDEFINED_SERVICE = "Predefined Service Constraint";
	public static final String CONSISTENCY_CONSTRAINT = "Consistency Constraint";
	public static final String CONTENT_VOLATILITY = "Content Volatility";
	public static final String STRUCTURAL_VOLATILITY = "Structural Volatility";
	public static final String CONSISTENCY = "Consistency Criticality";
	public static final String SECURITY_CRITICALITY = "Security Criticality";
	public static final String STORAGE_SIMILARITY = "Storage Similarity";
	public static final String AVAILABILITY = "Availability Criticality";
	public static final String SECURITY_CONTEXUALITY = "Security Contextuality";
	public static final String LATENCY = "Latency";

	@Id
	@GeneratedValue
	private Long id;
	private String code;
	private String name;
	@Column(length = 400)
	private String description;
	@Enumerated(EnumType.STRING)
	private CouplingType type;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(final String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof CouplingCriterion) {
			CouplingCriterion other = (CouplingCriterion) obj;
			return this == other || Objects.equal(id, other.id);
		} else {
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public CouplingType getType() {
		return type;
	}

	public void setType(final CouplingType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this.getClass()).add("id", id).add("name", name).add("type", type).toString();
	}

	public boolean is(String name) {
		return name.equals(this.name);
	}

}
