import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWithLowercaseInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить хлеб");

        Todos todos = new Todos();
        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWithUppercaseInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "хлеб");

        Todos todos = new Todos();
        todos.add(simpleTask);

        Task[] expected = {};
        Task[] actual = todos.search("ХЛЕБ");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchEmptyRequestInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить маме");

        Todos todos = new Todos();
        todos.add(simpleTask);

        Task[] expected = {};
        Task[] actual = todos.search("");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchRequestWithSpaceInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить маме");

        Todos todos = new Todos();
        todos.add(simpleTask);

        Task[] expected = {};
        Task[] actual = todos.search(" ");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWithLowercaseInEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();
        todos.add(epic);

        Task[] expected = {};
        Task[] actual = todos.search("хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWithUppercaseInEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();
        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchEmptyRequestInEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();
        todos.add(epic);

        Task[] expected = {};
        Task[] actual = todos.search("");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchRequestWithSpaceInEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Todos todos = new Todos();
        todos.add(epic);

        Task[] expected = {};
        Task[] actual = todos.search(" ");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWithLowercaseInMeetingInTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("версии");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWithLUppercaseInMeetingInTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Версии");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingInProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("НетоБанка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchEmptyRequestInMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchRequestWithSpaceInMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search(" ");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfNoTask() {
        Todos todos = new Todos();
        Task[] expected = {};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInAllTask() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Сходить в Банк");
        SimpleTask simpleTask2 = new SimpleTask(6, "Купить молоко");
        String[] subtasks = {"Банк", "Больница", "Школа"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Банк_приложение",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask1, epic, meeting};
        Task[] actual = todos.search("Банк");
        Assertions.assertArrayEquals(expected, actual);
    }

}
