package codility.contest2017;

/*
 * Codility: Elementary Level
 * https://app.codility.com/programmers/trainings/3/tennis_tournament/
 */
public class TennisTournament {
    
    /*
     * score: 100%
     * https://app.codility.com/demo/results/training2ZFX6D-XXA/
     */
    public int solution(int P, int C) {
        int teams = P / 2;
        return teams >= C ? C : teams;
    }

}
