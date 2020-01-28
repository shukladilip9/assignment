package fields;

public class Results {
	private String reference;

	private String formatted_address;

	private String[] types;

	private String icon;

	private String name;

	private Geometry geometry;

	private String id;

	private Photos[] photos;

	private String place_id;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Photos[] getPhotos() {
		return photos;
	}

	public void setPhotos(Photos[] photos) {
		this.photos = photos;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	@Override
	public String toString() {
		return "ClassPojo [reference = " + reference + ", formatted_address = " + formatted_address + ", types = "
				+ types + ", icon = " + icon + ", name = " + name + ", geometry = " + geometry + ", id = " + id
				+ ", photos = " + photos + ", place_id = " + place_id + "]";
	}

}
