public class Main {
    public static void main(String[] args) {
        String teamName = "abcd";
        String[] participants =  {"Alex", "Benn", "Cameron", "Darcy"};
        int[] skill = {2, 3, 1, 4};
        Team team1 = new Team(teamName, participants, skill);
        Course course = new Course();
        course.doIt(team1);
        team1.showResults();
    }
}
