package chapter14.strategy;

public class ApplicationRunner {
    private Application itsApplication = null;

    public ApplicationRunner(Application app) {
        this.itsApplication = app;
    }

    public void run() {
        itsApplication.init();
        while (!itsApplication.done()) {
            itsApplication.idle();
        }
        itsApplication.cleanup();
    }
}
