package co.com.ccarn.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ccarn.dtos.DetalleTrazabilidadDto;
import co.com.ccarn.dtos.ResponseDto;
import co.com.ccarn.dtos.TrazabilidadDto;
import co.com.ccarn.model.DetalleTrazabilidad;
import co.com.ccarn.model.Trazabilidad;
import co.com.ccarn.repositories.DetalleTrazabilidadRepository;
import co.com.ccarn.repositories.TrazabilidadRepository;
import co.com.ccarn.services.ITrazabilidadService;

@Service
public class TrazabilidadService implements ITrazabilidadService {

	@Autowired
	private CerrarConexionService cerrarConexionService;

	@Autowired
	private TrazabilidadRepository trazabilidadRepository;

	@Autowired
	private DetalleTrazabilidadRepository detalleTrazabilidadRepository;

	@Override
	public ResponseDto guardarTrazabilidad(TrazabilidadDto trazabilidadDto) {
		ResponseDto responseDto = new ResponseDto();
		if (trazabilidadDto.getId() != null) {
			Trazabilidad trazabilidad = mapeoToEntidad(trazabilidadDto);
			Trazabilidad trazabilidadGuardado = null;
			try {
				trazabilidadGuardado = trazabilidadRepository.save(trazabilidad);
				System.out.println(trazabilidadGuardado.getId() + " < < < < ID");
				if (trazabilidadGuardado != null) {

					if (trazabilidadGuardado.getId().equals(trazabilidad.getId())) {
						try {
							List<DetalleTrazabilidad> detalleTrazabiidads = detalleTrazabilidadRepository
									.findByTrazabilidadBean(trazabilidad);
							for (DetalleTrazabilidad detalleTrazabiidad : detalleTrazabiidads) {
								detalleTrazabilidadRepository.delete(detalleTrazabiidad);
							}
						} catch (Exception e) {
							responseDto.setCodigo("Error");
							responseDto.setMensaje("Error al actualizar la trazabilidad");
							e.printStackTrace();
							cerrarConexionService.cerrarConexion();
							return responseDto;
						}
					}
					if (trazabilidadDto.getDetalleTrazabilidad() != null && trazabilidadDto.getDetalleTrazabilidad().size() >0) {
						for (DetalleTrazabilidadDto detalleTrazabilidadDto : trazabilidadDto.getDetalleTrazabilidad()) {
							DetalleTrazabilidad detalleTrazabiidad = mapeoToDetalle(detalleTrazabilidadDto);
							detalleTrazabiidad.setTrazabilidadBean(trazabilidadGuardado);
							try {
								detalleTrazabilidadRepository.save(detalleTrazabiidad);
							} catch (Exception e) {
								responseDto.setCodigo("Error");
								responseDto.setMensaje("Error al guardar el detalle de la trazabilidad");
								e.printStackTrace();
								cerrarConexionService.cerrarConexion();
								return responseDto;
							}
						}
					}
					responseDto.setCodigo("Informativo");
					responseDto.setMensaje("Se actualizó correctamente el registro, " + trazabilidadGuardado.getId());
				}
				cerrarConexionService.cerrarConexion();
			} catch (Exception e) {
				responseDto.setCodigo("Error");
				responseDto.setMensaje("Error al guardar la trazabilidad");
				e.printStackTrace();
				cerrarConexionService.cerrarConexion();
				return responseDto;
			}
		} else {
			Trazabilidad trazabilidad = mapeoToEntidad(trazabilidadDto);
			Trazabilidad trazabilidadGuardado = null;
			try {
				trazabilidadGuardado = trazabilidadRepository.save(trazabilidad);
				System.out.println(trazabilidadGuardado.getId() + " < < < < ID");
				if (trazabilidadGuardado != null) {

					if (trazabilidadGuardado.getId().equals(trazabilidad.getId())) {
						try {
							List<DetalleTrazabilidad> detalleTrazabiidads = detalleTrazabilidadRepository
									.findByTrazabilidadBean(trazabilidad);
							for (DetalleTrazabilidad detalleTrazabiidad : detalleTrazabiidads) {
								detalleTrazabilidadRepository.delete(detalleTrazabiidad);
							}
						} catch (Exception e) {
							responseDto.setCodigo("Error");
							responseDto.setMensaje("Error al actualizar la trazabilidad");
							e.printStackTrace();
							cerrarConexionService.cerrarConexion();
							return responseDto;
						}
					}
					if (trazabilidadDto.getDetalleTrazabilidad() != null && trazabilidadDto.getDetalleTrazabilidad().size() >0) {
						for (DetalleTrazabilidadDto detalleTrazabiidadDto : trazabilidadDto.getDetalleTrazabilidad()) {
							DetalleTrazabilidad detalleTrazabiidad = mapeoToDetalle(detalleTrazabiidadDto);
							detalleTrazabiidad.setTrazabilidadBean(trazabilidadGuardado);
							try {
								detalleTrazabilidadRepository.save(detalleTrazabiidad);
							} catch (Exception e) {
								responseDto.setCodigo("Error");
								responseDto.setMensaje("Error al guardar el detalle de la trazabilidad");
								e.printStackTrace();
								cerrarConexionService.cerrarConexion();
								return responseDto;
							}
						}
					}
					responseDto.setCodigo("Informativo");
					responseDto.setMensaje("Se actualizó correctamente el registro, " + trazabilidadGuardado.getId());
				}
				cerrarConexionService.cerrarConexion();
			} catch (Exception e) {
				responseDto.setCodigo("Error");
				responseDto.setMensaje("Error al guardar la trazabilidad");
				e.printStackTrace();
				cerrarConexionService.cerrarConexion();
				return responseDto;
			}
		}
		return responseDto;
	}

	private Trazabilidad mapeoToEntidad(TrazabilidadDto trazabilidadDto) {
		ModelMapper modelMapper = new ModelMapper();
		Trazabilidad trazabilidad = modelMapper.map(trazabilidadDto, Trazabilidad.class);
		return trazabilidad;
	}
	
	private DetalleTrazabilidad mapeoToDetalle(DetalleTrazabilidadDto detalleTrazabiidadDto) {
		ModelMapper modelMapper = new ModelMapper();
		DetalleTrazabilidad detalleTrazabiidad = modelMapper.map(detalleTrazabiidadDto, DetalleTrazabilidad.class);
		return detalleTrazabiidad;
	}

}
