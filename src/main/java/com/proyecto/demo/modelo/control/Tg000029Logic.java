package com.proyecto.demo.modelo.control;

import com.proyecto.demo.dataaccess.dao.*;
import com.proyecto.demo.dto.mapper.ITg000029Mapper;
import com.proyecto.demo.exceptions.*;
import com.proyecto.demo.modelo.*;
import com.proyecto.demo.modelo.dto.Tg000029DTO;
import com.proyecto.demo.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("Tg000029Logic")
public class Tg000029Logic implements ITg000029Logic {
    private static final Logger log = LoggerFactory.getLogger(Tg000029Logic.class);

    /**
     * DAO injected by Spring that manages Tg000029 entities
     *
     */
    @Autowired
    private ITg000029DAO tg000029DAO;
    @Autowired
    private ITg000029Mapper tg000029Mapper;
    @Autowired
    private Validator validator;

    /**
    * DAO injected by Spring that manages Tp000001 entities
    *
    */
    @Autowired
    private ITp000001DAO tp000001DAO;

    public void validateTg000029(Tg000029 tg000029) throws Exception {
        try {
            Set<ConstraintViolation<Tg000029>> constraintViolations = validator.validate(tg000029);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Tg000029> constraintViolation : constraintViolations) {
                    strMessage.append(constraintViolation.getPropertyPath()
                                                         .toString());
                    strMessage.append(" - ");
                    strMessage.append(constraintViolation.getMessage());
                    strMessage.append(". \n");
                }

                throw new Exception(strMessage.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Tg000029> getTg000029() throws Exception {
        log.debug("finding all Tg000029 instances");

        List<Tg000029> list = new ArrayList<Tg000029>();

        try {
            list = tg000029DAO.findAll();
        } catch (Exception e) {
            log.error("finding all Tg000029 failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Tg000029");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveTg000029(Tg000029 entity) throws Exception {
        log.debug("saving Tg000029 instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Tg000029");
            }

            validateTg000029(entity);

            if (getTg000029(entity.getCodSubTipoCotizante()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            tg000029DAO.save(entity);

            log.debug("save Tg000029 successful");
        } catch (Exception e) {
            log.error("save Tg000029 failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteTg000029(Tg000029 entity) throws Exception {
        log.debug("deleting Tg000029 instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Tg000029");
        }

        if (entity.getCodSubTipoCotizante() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "codSubTipoCotizante");
        }

        List<Tp000001> tp000001s = null;

        try {
            tp000001s = tp000001DAO.findByProperty("tg000029.codSubTipoCotizante",
                    entity.getCodSubTipoCotizante());

            if (Utilities.validationsList(tp000001s) == true) {
                throw new ZMessManager().new DeletingException("tp000001s");
            }

            tg000029DAO.delete(entity);

            log.debug("delete Tg000029 successful");
        } catch (Exception e) {
            log.error("delete Tg000029 failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateTg000029(Tg000029 entity) throws Exception {
        log.debug("updating Tg000029 instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Tg000029");
            }

            validateTg000029(entity);

            tg000029DAO.update(entity);

            log.debug("update Tg000029 successful");
        } catch (Exception e) {
            log.error("update Tg000029 failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<Tg000029DTO> getDataTg000029() throws Exception {
        try {
            List<Tg000029> tg000029 = tg000029DAO.findAll();

            List<Tg000029DTO> tg000029DTO = new ArrayList<Tg000029DTO>();

            for (Tg000029 tg000029Tmp : tg000029) {
                Tg000029DTO tg000029DTO2 = tg000029Mapper.tg000029ToTg000029DTO(tg000029Tmp);
                tg000029DTO.add(tg000029DTO2);
            }

            return tg000029DTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Tg000029 getTg000029(String codSubTipoCotizante)
        throws Exception {
        log.debug("getting Tg000029 instance");

        Tg000029 entity = null;

        try {
            entity = tg000029DAO.findById(codSubTipoCotizante);
        } catch (Exception e) {
            log.error("get Tg000029 failed", e);
            throw new ZMessManager().new FindingException("Tg000029");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Tg000029> findPageTg000029(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Tg000029> entity = null;

        try {
            entity = tg000029DAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Tg000029 Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberTg000029() throws Exception {
        Long entity = null;

        try {
            entity = tg000029DAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Tg000029 Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<Tg000029> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Tg000029> list = new ArrayList<Tg000029>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between " + value +
                        " and " + value2 + ")")
                        : (tempWhere + " AND (model." + variable + " between " +
                        value + " and " + value2 + ")");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = tg000029DAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
