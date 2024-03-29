
package acme.features.administrator.spamFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.spamFilters.SpamFilter;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorSpamFilterUpdateService implements AbstractUpdateService<Administrator, SpamFilter> {

	@Autowired
	private AdministratorSpamFilterRepository repository;


	@Override
	public boolean authorise(final Request<SpamFilter> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<SpamFilter> request, final SpamFilter entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<SpamFilter> request, final SpamFilter entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "badWords", "threshold");
	}

	@Override
	public SpamFilter findOne(final Request<SpamFilter> request) {
		assert request != null;
		SpamFilter result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneSpamFilterById(id);

		return result;
	}

	@Override
	public void validate(final Request<SpamFilter> request, final SpamFilter entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void update(final Request<SpamFilter> request, final SpamFilter entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
