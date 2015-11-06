package be.jef.servlets.characters;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.jef.entities.Clan;
import be.jef.entities.Personage;
import be.jef.entities.attributes.Attribute;
import be.jef.entities.attributes.AttributeColumn;
import be.jef.entities.attributes.PersAttCol;
import be.jef.entities.attributes.PersAttribute;
import be.jef.services.ClanService;
import be.jef.services.PersonageService;
import be.jef.services.attributes.AttributeColumnService;
import be.jef.services.attributes.AttributeService;
import be.jef.services.attributes.PersAttColService;
import be.jef.services.attributes.PersAttributeService;

@WebServlet("/characters/load.htm")
public class LoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/characters/load.jsp";
	private final transient PersonageService personageService = new PersonageService();
	private final transient ClanService clanService = new ClanService();
	private final transient PersAttColService persAttColService = new PersAttColService();
	private final transient AttributeColumnService attributeColumnService = new AttributeColumnService();
	private final transient AttributeService attributeService = new AttributeService();
	private final transient PersAttributeService persAttributeService = new PersAttributeService();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Personage> personages = personageService.findAll();
		request.setAttribute("personages", personages);
		String persId = request.getParameter("persId");
		if (persId != null) {
			Personage personage = personageService.read(Long.parseLong(persId));
			request.setAttribute("personage", personage);
			Clan clan = personage.getClan();
			request.setAttribute("clan", clan);
			List<AttributeColumn> attributeColumns = attributeColumnService
					.findAll();
			request.setAttribute("attributeColumns", attributeColumns);
			Map<Attribute, String> persAttributesByAttribute = new HashMap<Attribute, String>();
			List<PersAttCol> persAttCols = persAttColService.findAll();
			List<Attribute> attributes = attributeService.findAll();

			for (Attribute attribute : attributes) {
				persAttributesByAttribute.put(attribute, Long.toString(persAttributeService
						.findPersAttributeForPersonageAndAttribute(personage,
								attribute).getLevel()));
			}
			request.setAttribute("persAttributesByAttribute",
					persAttributesByAttribute);

			request.setAttribute("attributes", attributes);
			request.setAttribute("persAttCols", persAttCols);
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
