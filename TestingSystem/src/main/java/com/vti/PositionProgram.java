package com.vti;
 
import java.util.Date;
import java.util.List;
 
import com.vti.entity.Position;
import com.vti.repository.DepartmentRepository;
import com.vti.repository.PositionRepository;
 
public class PositionProgram {
	public static void main(String[] args) {
		PositionRepository repository = new PositionRepository();
 
//		System.out.println("***********GET ALL POSITIONS***********");
//
//		List<Position> positions = repository.getAllPositions();
//
//		for (Position position : positions) {
//			System.out.println(position);	
//		}
// 
 
//		System.out.println("\n\n***********GET POSITION BY ID***********");
//
//		Position positionById = repository.getPositiontByID((short) 2);
//		System.out.println(positionById);
//
//		System.out.println("\n\n***********GET POSITION BY NAME***********");
//
//		Position positionByName = repository.getPositionByName("DEV");
//		System.out.println(positionByName);
//
//		System.out.println("\n\n***********CREATE POSITION***********");

		Position positionCreate = new Position();
		positionCreate.setPositionName(Position.PositionName.SCRUMMASTER);
		repository.createPositiont(positionCreate);
//
//		System.out.println("\n\n***********UPDATE POSITION 1***********");
//
//		repository.updatePosition((short) 6, "PM");
//
//		System.out.println("\n\n***********UPDATE POSITION 2***********");
//		Position positionUpdate = new Position();
//		positionUpdate.setId((short) 3);
//		positionUpdate.setName("TEST");
//		repository.updatePosition(positionUpdate);
//
//		System.out.println("\n\n***********DELETE POSITIONS***********");
//		repository.deletePosition((short) 2);
 
//		System.out.println("***********CHECK POSITION EXISTS BY ID***********");
//		System.out.println(repository.isPositionExistsByID((short) 1));
//
//		System.out.println("***********CHECK POSITION EXISTS BY NAME***********");
//		System.out.println(repository.isPositionExistsByName("DEV"));
 
	}
}