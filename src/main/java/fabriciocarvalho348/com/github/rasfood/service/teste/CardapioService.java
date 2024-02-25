package fabriciocarvalho348.com.github.rasfood.service.teste;

import fabriciocarvalho348.com.github.rasfood.dao.CardapioDao;
import fabriciocarvalho348.com.github.rasfood.dao.CategoriaDao;
import fabriciocarvalho348.com.github.rasfood.entity.Cardapio;
import fabriciocarvalho348.com.github.rasfood.entity.Categoria;
import fabriciocarvalho348.com.github.rasfood.util.JPAUtil;


import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        cadastrarProdutoCardapio(entityManager, cadastrarCategoria(entityManager));
    }

    private static Categoria cadastrarCategoria(EntityManager entityManager) {
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria pratoPrincipal = new Categoria("Prato principal");
        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(pratoPrincipal);
        entityManager.getTransaction().commit();
        entityManager.clear();
        return pratoPrincipal;
    }

    private static void cadastrarProdutoCardapio(EntityManager entityManager, Categoria categoria) {

        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setCategoria(categoria);
        risoto.setValor((BigDecimal.valueOf(88.50)));

        Cardapio peixeAssado  = new Cardapio();
        peixeAssado.setNome("peixe");
        peixeAssado.setDescricao("peixe");
        peixeAssado.setDisponivel(true);
        peixeAssado.setCategoria(categoria);
        peixeAssado.setValor((BigDecimal.valueOf(60.00)));

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();
        cardapioDao.cadastrar(risoto);
        entityManager.flush();
        cardapioDao.cadastrar(peixeAssado);
        entityManager.flush();
//        System.out.println("O prato consultado foi: " + cardapioDao.consultarPorId(2));
//        System.out.println("O prato consultado foi: " + cardapioDao.consultarPorId(1));
        cardapioDao.consultarTodos().forEach(elemento -> System.out.println("O prato consultado foi: " + elemento));

        entityManager.clear();
    }
}
