package com.example.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursomc.domain.Pedido;
import com.example.cursomc.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping
	public List<Pedido> buscarTudo(){
		List<Pedido> lista = new ArrayList<>();
		lista.addAll(service.buscarTudo());
		return lista;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscarPorID(@PathVariable Integer id){
		Pedido obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
}
