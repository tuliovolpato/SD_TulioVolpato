package br.inatel.labs.labjpa.service;


import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import br.inatel.labs.labjpa.repository.NotaCompraItemRepository;
import br.inatel.labs.labjpa.repository.NotaCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NotaCompraService {

    @Autowired
    private NotaCompraRepository ncRepository;

    @Autowired
    private NotaCompraItemRepository nciRepository;


    // Nota Compra
    public NotaCompra salvar(NotaCompra nc){

        return ncRepository.save(nc);

    }

    public Optional<NotaCompra> buscarNotaCompraPeloId(Long id){

        return ncRepository.findById(id);

    }

    public List<NotaCompra> listaNotaCompra(){

        return ncRepository.findAll();

    }

    public NotaCompra buscarNotaCompraPeloIdComListaItem(Long id){

        Optional<NotaCompra> opNotaCompra = ncRepository.findById(id);
        if(opNotaCompra.isPresent() ) {
            NotaCompra notaCompra = opNotaCompra.get();
            notaCompra.getListaNotaCompraItem().size();
            return notaCompra;
        } else {

            throw new RuntimeException("Nenhuma nota compra encontrada");
        }

    }

    // Nota Compra Item

    public NotaCompraItem salvar(NotaCompraItem item){

        return nciRepository.save(item);

    }

    public Optional<NotaCompraItem> buscarNotaCompraItemPeloId(Long id){

        return nciRepository.findById(id);

    }

    public List<NotaCompraItem> listarNotaCompraItem(){

        return nciRepository.findAll();

    }

}
