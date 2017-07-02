/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pzlmtch.bean;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabi
 */
@XmlRootElement
public class PuzzleDetails {
    private int height;
    private int width;
    private String piecePicture;
    private String puzzlePicture;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getPiecePicture() {
        return piecePicture;
    }

    public void setPiecePicture(String piecePicture) {
        this.piecePicture = piecePicture;
    }

    public String getPuzzlePicture() {
        return puzzlePicture;
    }

    public void setPuzzlePicture(String puzzlePicture) {
        this.puzzlePicture = puzzlePicture;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.height;
        hash = 83 * hash + this.width;
        hash = 83 * hash + Objects.hashCode(this.piecePicture);
        hash = 83 * hash + Objects.hashCode(this.puzzlePicture);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PuzzleDetails other = (PuzzleDetails) obj;
        if (this.height != other.height) {
            return false;
        }
        if (this.width != other.width) {
            return false;
        }
        if (!Objects.equals(this.piecePicture, other.piecePicture)) {
            return false;
        }
        if (!Objects.equals(this.puzzlePicture, other.puzzlePicture)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PuzzleDetails{" + "height=" + height + ", width=" + width + ", piecePicture=" + piecePicture + ", puzzlePicture=" + puzzlePicture + '}';
    }
    
    
}
