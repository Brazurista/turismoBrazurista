package br.itb.projeto.turismo.service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.turismo.model.entity.Usuario;
import br.itb.projeto.turismo.model.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();

		return usuarios;
	}

	public Usuario findbyId(long id) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow();
		return usuario;
	}

	public Usuario findByEmail(String email) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		return usuario;
	}

	@Transactional
	public Usuario create(Usuario usuario) {
		String senha = Base64.getEncoder().encodeToString("123456".getBytes());

		usuario.setSenha(senha);
		usuario.setDataCadastro(LocalDateTime.now());
		usuario.setStatusUsuario("ATIVO");

		return usuarioRepository.save(usuario);
	}

	@Transactional
	public Usuario signin(String email, String senha) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if (usuario != null) {
			if (!usuario.getStatusUsuario().equals("INATIVO")) {
				byte[] decodedPass = Base64.getDecoder().decode(usuario.getSenha());
				if (new String(decodedPass).equals(senha)) {
					return usuario;
				}
			}

		}
		return null;
	}

	@Transactional
	public Usuario update(long id) {
		// java.util.Optional
		Optional<Usuario> _usuario = usuarioRepository.findById(id);
		if (_usuario.isPresent()) {
			Usuario usuarioAtualizada = _usuario.get();
			usuarioAtualizada.setStatusUsuario("LTDA");

			return usuarioRepository.save(usuarioAtualizada);

		}
		return null;
	}

	@Transactional
	public Usuario inativar(long id) {
		// java.util.Optional
		Optional<Usuario> _usuario = usuarioRepository.findById(id);
		if (_usuario.isPresent()) {
			Usuario usuarioAtualizada = _usuario.get();
			usuarioAtualizada.setStatusUsuario("INATIVO");

			return usuarioRepository.save(usuarioAtualizada);
		}

		return null;

	}

	@Transactional
	public Usuario reativar(long id) {
		// java.util.Optional
		Optional<Usuario> _usuario = usuarioRepository.findById(id);
		if (_usuario.isPresent()) {
			Usuario usuarioAtualizada = _usuario.get();
			String senha = Base64.getEncoder().encodeToString("123456".getBytes());

			usuarioAtualizada.setSenha(senha);
			usuarioAtualizada.setDataCadastro(LocalDateTime.now());
			usuarioAtualizada.setStatusUsuario("ATIVO");

			return usuarioRepository.save(usuarioAtualizada);
		}

		return null;

	}

	@Transactional
	public Usuario alterarSenha(long id, Usuario usuario) {
		// java.util.Optional
		Optional<Usuario> _usuario = usuarioRepository.findById(id);
		if (_usuario.isPresent()) {
			Usuario usuarioAtualizada = _usuario.get();

			String senha = Base64.getEncoder().encodeToString(usuario.getSenha().getBytes());
			usuarioAtualizada.setSenha(senha);

			return usuarioRepository.save(usuarioAtualizada);
		}

		return null;

	}

}