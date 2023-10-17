public class SimpleTask extends Task {
    private String title;

    public SimpleTask(int id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean matches(String query) {
        if (query.isEmpty()) {
            return false;
        }
        if (query.equals(" ")) {
            return false;
        }
        if (title.contains(query)) {
            return true;
        }
        return false;
    }

}
