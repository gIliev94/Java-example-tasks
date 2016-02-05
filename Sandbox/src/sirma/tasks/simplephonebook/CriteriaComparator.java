package sirma.tasks.simplephonebook;

import java.util.Comparator;

public class CriteriaComparator implements Comparator<Contact> {

	private String criteriaColumn;

	CriteriaComparator(String criteriaColumn) {
		this.criteriaColumn = criteriaColumn;
	}

	@Override
	public int compare(Contact c1, Contact c2) {
		int result;

		switch (criteriaColumn) {

		case "name":
			result = (c1.getName()).compareToIgnoreCase(c2.getName());
			break;

		case "phone":
			result = (c1.getPhone()).compareToIgnoreCase(c2.getPhone());
			break;

		case "city":
			result = (c1.getCity()).compareToIgnoreCase(c2.getCity());

			if (c1.getCity().equals("")) {
				result = 1;
			}

			if (c2.getCity().equals("")) {
				result = -1;
			}

			break;

		case "name!":
			result = (c2.getName()).compareToIgnoreCase(c1.getName());
			break;

		case "phone!":
			result = (c2.getPhone()).compareToIgnoreCase(c1.getPhone());
			break;

		case "city!":
			result = (c2.getCity()).compareToIgnoreCase(c1.getCity());
			break;

		default:
			result = 0;
			break;
		}
		return result;
	}

}
