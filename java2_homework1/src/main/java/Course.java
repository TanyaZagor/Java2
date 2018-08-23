public class Course {
    private int[] obstacles = {1, 2, 3, 4};
    public void doIt(Team team) {
        String[] participants = team.getParticipants();
        int[] skill = team.getSkill();
        int[] results = new int[participants.length];
        for(int i = 0; i < participants.length; i++) {
            for(int j = 0; j < obstacles.length; j++) {
                if(skill[i] > obstacles[j]) {
                    results[i]++;
                }
            }
        }
        team.setResults(results);
    }
}
