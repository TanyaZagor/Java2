public class Team {
    private String teamName;
    private String[] participants;
    private int[] skill;
    private int[] results;
    public  Team(String teamName, String[] participants, int[] skill) {
        this.teamName = teamName;
        this.participants = participants;
        this.skill = skill;
    }
    public int[] getSkill() {
        return this.skill;
    }
    public String[] getParticipants() {
        return this.participants;
    }
    public void setResults(int[] results) {
        this.results = results;
    }
    public void showResults() {
        for(int i =0; i < participants.length; i++) {
            System.out.println(participants[i] + ": " + results[i]);
        }
    }
    public void showParticipants() {
        for(String p : participants)
            System.out.println(p);
    }
}
