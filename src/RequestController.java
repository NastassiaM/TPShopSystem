/**
 * Created by Viktoria on 22.12.2014.
 */
public class RequestController {
    private DemandForm demandForm;

    public RequestController() {
        demandForm = new DemandForm(this);
    }

    public void finalize() throws Throwable {
    }

    public void requestForCreate(){
        //catalog()
        demandForm.showForm();
    }
}
