
package acme.entities.spamFilters;

import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Builder
public class SpamFilter extends DomainEntity {

	private static final long	serialVersionUID	= 21L;

	//	@Singular
	@ElementCollection(fetch = FetchType.EAGER)
	private Collection<String>	badWords;

	//@Default
	private Double				threshold;

	//	public static SpamFilterBuilder builder() {
	//		return new SpamFilterBuilder().badWords(new ArrayList<String>(Arrays.asList("sex", "viagra")));
	//	}
}
