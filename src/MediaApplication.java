import Controller.MediaController;
import Model.MediaModel;
import View.MediaView;
import data.SampleData;

public class MediaApplication {
    private static final MediaView view = new MediaView();
    private static final MediaModel model = new MediaModel();
    private static final MediaController controller = new MediaController(model, view);

    public static void main(String[] args) throws InterruptedException {
        controller.run();
    }
}
