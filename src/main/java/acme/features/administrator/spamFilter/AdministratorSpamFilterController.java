
package acme.features.administrator.spamFilter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.spamFilters.SpamFilter;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/spam-filter/")
public class AdministratorSpamFilterController extends AbstractController<Administrator, SpamFilter> {

	@Autowired
	private AdministratorSpamFilterShowService	showService;

	@Autowired
	private AdministratorSpamFilterListService	listService;


	@PostConstruct
	private void inicialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
	}

}
