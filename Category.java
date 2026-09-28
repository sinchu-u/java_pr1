import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Category {
    private int id; // Унікальний ідентифікатор категорії
    private String name; // Назва категорії

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Категорія{" +
                "id=" + id +
                ", назва='" + name + '\'' +
                '}';
    }
}
