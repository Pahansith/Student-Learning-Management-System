/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.builder;


import edu.ijse.lms.builder.DTOBuilder;
import edu.ijse.lms.dto.SuperDTO;
import java.io.IOException;

/**
 *
 * @author Pahansith
 */
public class BuilderManager {
    private DTOBuilder builder;

    public BuilderManager(DTOBuilder builder) {
        this.builder = builder;
    }
    
    
    public SuperDTO getDTO() throws IOException{
        builder.initAttributes();
        return builder.getDto();
    }
}
