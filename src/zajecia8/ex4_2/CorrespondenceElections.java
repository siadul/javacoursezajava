package zajecia8.ex4_2;

public class CorrespondenceElections extends AbstractElections
        implements CanVoteInterface, CanCountVotesInterface, FakeableInterface {

    @Override
    public int countVotes() {
        return 1000;
    }

    @Override
    public boolean vote() {
        return false;
    }

    @Override
    public int fake() {
        return 95;
    }
}
