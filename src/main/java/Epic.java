public class Epic extends Task {
    private String[] subtasks = new String[0];

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        if (query.isEmpty()) {
            return false;
        }
        if (query.equals(" ")) {
            return false;
        }
        for (String subtask : subtasks)
            if (subtask.contains(query)) {
                return true;
            }
        return false;
    }
}
