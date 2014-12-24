import javax.xml.crypto.Data;

/**
 * Created by Viktoria on 22.12.2014.
 */
public class DemandController {
    private DemandForm demandForm;

    public DemandController() {
        demandForm = new DemandForm(this);
    }

    public void finalize() throws Throwable {
    }

    public void requestForCreate(){
        //catalog()
        demandForm.showForm();
    }

    public Demand getDemandByID(String id){
        return DataAccessor.demandList.getDemand(id);
    }

    public void requestForEdit(String id) {
        Demand demand = getDemandByID(id);
        demandForm.showEditForm(demand);
    }

    public boolean requestForDelete(String id) {
        Demand demand = DataAccessor.demandList.getDemand(id);
        DataAccessor.demandList.remove(demand);
        return DataAccessor.demandList.writeToFile();
    }
}
