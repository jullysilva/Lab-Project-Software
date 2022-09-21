package com.puc.aluguel.services;

import com.puc.aluguel.exceptions.BusinesException;
import com.puc.aluguel.mapper.AutomovelMapper;
import com.puc.aluguel.model.dto.AutomovelDTO;
import com.puc.aluguel.model.entity.Automovel;
import com.puc.aluguel.repository.AutomovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutomovelService {

    @Autowired
    AutomovelRepository repository;

    public AutomovelDTO buscarAutomovelPorId(Long id) {
        var automovel = repository.findById(id).orElseThrow(() -> new BusinesException("Erro ao buscar automovel"));

        return AutomovelMapper.INSTANCE.entityToDto(automovel);
    }

    public Automovel buscarEntityAutomovelPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new BusinesException("Erro ao buscar automovel"));
    }

    public List<AutomovelDTO> buscarTodos() {
        var automovelList = repository.findAll();
        return AutomovelMapper.INSTANCE.entityToDto(automovelList);
    }

    public void salvarListAutomoveis() {
        listaAutomovel().stream().forEach(automovel -> repository.save(automovel));
    }

    public List<Automovel> listaAutomovel() {
        List<Automovel> automovelList = new ArrayList<>();

        automovelList.add(Automovel.builder().ano(2000).placa("AAA1111").marca("Honda").modelo("aaa").matricula("1111").build());
        automovelList.add(Automovel.builder().ano(2002).placa("ERT2653").marca("FIAT").modelo("bbb").matricula("1323").build());
        automovelList.add(Automovel.builder().ano(2004).placa("DFG4357").marca("FIAT").modelo("ccc").matricula("3252").build());
        automovelList.add(Automovel.builder().ano(2005).placa("DFG3453").marca("Honda").modelo("ddd").matricula("4654").build());
        automovelList.add(Automovel.builder().ano(2007).placa("SDF6345").marca("FIAT").modelo("eee").matricula("23452").build());

        return automovelList;
    }

}