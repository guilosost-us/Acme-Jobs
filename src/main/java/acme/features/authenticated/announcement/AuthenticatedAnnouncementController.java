
package acme.features.authenticated.announcement;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.announcements.Announcement;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/announcement/")
public class AuthenticatedAnnouncementController extends AbstractController<Authenticated, Announcement> {

	@Autowired
	private AuthenticatedAnnouncementListService	listService;

	@Autowired
	private AuthenticatedAnnouncementShowService	showService;


	@PostConstruct
	private void inicialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
