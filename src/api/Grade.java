package api;

public class Grade {
    private Subject subject;
    private int rating;

    public Grade(Subject subject, int rating) {
        this.subject = subject;
        this.rating = rating;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return subject + "[" + subject.getSymbol() + "]" + " (" + rating + ")";
    }
}
