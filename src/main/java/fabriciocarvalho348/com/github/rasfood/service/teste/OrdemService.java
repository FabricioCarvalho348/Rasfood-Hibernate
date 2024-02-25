package fabriciocarvalho348.com.github.rasfood.service.teste;

import fabriciocarvalho348.com.github.rasfood.dao.ClienteDao;
import fabriciocarvalho348.com.github.rasfood.dao.EnderecoDao;
import fabriciocarvalho348.com.github.rasfood.dao.OrdemDao;
import fabriciocarvalho348.com.github.rasfood.entity.ClienteId;
import fabriciocarvalho348.com.github.rasfood.entity.Ordem;
import fabriciocarvalho348.com.github.rasfood.util.CargaDeDadosUtil;
import fabriciocarvalho348.com.github.rasfood.util.JPAUtil;
import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CargaDeDadosUtil.cadastrarClientes(entityManager);
        CargaDeDadosUtil.cadastrarOrdensClientes(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);
        EnderecoDao enderecoDao = new EnderecoDao(entityManager);
        Ordem ordem = ordemDao.joinFetchCliente(2);
        System.out.println(enderecoDao.consultarClientes(null, "Sao Paulo", null));
        System.out.println(enderecoDao.consultarClientesUsandoCriteria(null, "Sao Paulo", null));

        ClienteDao clienteDao = new ClienteDao(entityManager);
        System.out.println(clienteDao.consultarPorId(new ClienteId("tayane@email.com", "111111111123")));
        System.out.println(clienteDao.consultarPorNome("Maria"));
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(ordem.getCliente().getNome());
    }
}
