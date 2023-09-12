package author;


public class Author {
    private Integer authorId;
    private String  firstName;
    private String lastnName;
    private int age;

    public Author(Integer authorId, String firstName, String lastnName, int age) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastnName = lastnName;
        this.age = age;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastnName() {
        return lastnName;
    }

    public void setLastnName(String lastnName) {
        this.lastnName = lastnName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
