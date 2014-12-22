/**
 * Created by Viktoria on 22.12.2014.
 */
public class RequestController {
    private RequestForm requestForm;

    public RequestController() {
        requestForm = new RequestForm(this);
    }

    public void finalize() throws Throwable {
    }

    public void requestForCreate(){
        //catalog()
        requestForm.showForm();
    }
}
