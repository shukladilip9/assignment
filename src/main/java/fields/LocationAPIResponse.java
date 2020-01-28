package fields;

import java.util.List;

public class LocationAPIResponse {

	private List<String> html_attributions;

	private List<Results> results;

	private String status;

	public List<String> getHtml_attributions() {
		return html_attributions;
	}

	public void setHtml_attributions(List<String> html_attributions) {
		this.html_attributions = html_attributions;
	}

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ClassPojo [html_attributions = " + html_attributions + ", results = " + results + ", status = " + status
				+ "]";
	}

}
