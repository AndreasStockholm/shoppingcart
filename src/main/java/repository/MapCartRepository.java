package repository;

import model.Cart;
import model.CartRowItem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * Created by andgra on 2014-11-21.
 */
@Service
public class MapCartRepository implements CartRepository {
    private ProductRepository productRepository;
    private Map<String, Cart> cartMap = new HashMap<String, Cart>();

    @Autowired
    public MapCartRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Cart saveCart(Cart cart)  {
        cartMap.put(cart.getId(), cart);
        return cart;
    }

    @Override
    public List<Cart> retrieveCarts() {
        ArrayList<Cart> cartArrayList = new ArrayList<Cart>(cartMap.values());
        return cartArrayList;
    }

    @Override
    public Optional<Cart> retrieveCart(String id) {
        return Optional.ofNullable(cartMap.get(id));
    }

    @Override
    public Optional<Cart> deleteCart(String id) {
        return Optional.ofNullable(cartMap.remove(id));
    }

    @Override
    public Optional<Cart> addProductInCart(String cartId, String jsonProduct)  {
        Map<String, Object> valueMap = null;
        try {
            valueMap = new ObjectMapper().readValue(jsonProduct, new TypeReference<Map<String, Object>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        Cart cart = Optional.ofNullable(cartMap.get(cartId)).get();
        Product product = productRepository.retrieveProduct((String) valueMap.get("productId")).get();
        double quantity = Double.parseDouble(valueMap.get("quantity").toString());
        CartRowItem cartRowItem = new CartRowItem(product, quantity);

        cart.addProductInRow(cartRowItem);
        return Optional.ofNullable(cart);
    }
}
