package com.voterapp.Service;

import com.voterapp.Exceptions.InValidVoterException;

public interface IElectionBooth {
boolean checkAvailability(int age,String locality,int vid) throws InValidVoterException;

}
