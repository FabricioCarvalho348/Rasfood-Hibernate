package fabriciocarvalho348.com.github.rasfood.service.teste;

import fabriciocarvalho348.com.github.rasfood.dao.CardapioDao;
import fabriciocarvalho348.com.github.rasfood.util.CargaDeDadosUtil;
import fabriciocarvalho348.com.github.rasfood.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioServiceTeste2 {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        System.out.println("Lista de produtos por valor: " + cardapioDao.consultarPorValor(BigDecimal.valueOf(59.00)));
        entityManager.close();
    }
}
