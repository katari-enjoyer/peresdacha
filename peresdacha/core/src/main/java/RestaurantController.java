import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private List<Restaurant> restaurants = new ArrayList<>();
    private Map<Integer, List<MenuItem>> menuItems = new HashMap<>();

    public RestaurantController() {
        // Заполняем in-memory хранилище примерами ресторанов и их меню
        List<MenuItem> restaurant1Menu = new ArrayList<>();
        restaurant1Menu.add(new MenuItem("Блюдо 1", "Описание 1", 10.99));
        restaurant1Menu.add(new MenuItem("Блюдо 2", "Описание 2", 15.99));
        menuItems.put(1, restaurant1Menu);

        List<MenuItem> restaurant2Menu = new ArrayList<>();
        restaurant2Menu.add(new MenuItem("Блюдо 3", "Описание 3", 12.99));
        restaurant2Menu.add(new MenuItem("Блюдо 4", "Описание 4", 19.99));
        menuItems.put(2, restaurant2Menu);
    }

    @GetMapping("/menu/{restaurantId}")
    public List<MenuItem> getMenu(@PathVariable int restaurantId) {
        return menuItems.get(restaurantId);
    }
}
