package VO;

public class PersonasProductosVo {
	private Long codigo;
	private Long personaId;
	private Long productoId;
	
	public PersonasProductosVo() {
		
	}

	public PersonasProductosVo(Long personaId, Long productoId) {
		super();
		this.personaId = personaId;
		this.productoId = productoId;
	}

	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}
	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "PersonasProductosVo [codigo"+codigo+"personaId=" + personaId + ", productoId=" + productoId + "]";
	}
	
	

	
}
