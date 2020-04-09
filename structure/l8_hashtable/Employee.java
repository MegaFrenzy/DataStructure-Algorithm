package l8_hashtable;

/**
 * @Description:
 * @Author: MegaFrenzy
 * @CreateTime: 2020-03-09 22:14
 */
public class Employee {
    public int id;
    public String name;
    public Employee next;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
