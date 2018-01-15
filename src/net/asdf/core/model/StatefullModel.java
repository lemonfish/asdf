

package net.asdf.core.model;

public class StatefullModel implements Model {

	public static final String STATUS_NORMAL = "";
	public static final String STATUS_UPDATE = "update";
	public static final String STATUS_INSERT = "insert";
	public static final String STATUS_DELETE = "delete";
    public static final String ROW_STATUS_FIELD = "rowStatus";

    private transient String rowStatus = STATUS_NORMAL;

    public String getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(String rowStatus) {
        this.rowStatus = rowStatus;
    }

}



class SampleModel extends StatefullModel {

	private String name;

    public SampleModel(String name, String status) {
        this.name = name;
        this.setRowStatus(status);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
