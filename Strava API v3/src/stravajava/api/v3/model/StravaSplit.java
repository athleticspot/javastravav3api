package stravajava.api.v3.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Dan Shannon
 *
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class StravaSplit {
	private Float distance;
	private Integer elapsedTime;
	private Float elevationDifference;
	private Integer movingTime;
	private Integer split;
}