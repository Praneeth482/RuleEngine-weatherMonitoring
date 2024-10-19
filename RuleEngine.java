import java.util.Map;
public class RuleEngine {
	    
	    public Node createRule(String ruleString) {
	        if (ruleString.contains("AND")) {
	            String[] parts = ruleString.split("AND");
	            return new Node("operator", createRule(parts[0].trim()), createRule(parts[1].trim()));
	        } else if (ruleString.contains("OR")) {
	            String[] parts = ruleString.split("OR");
	            return new Node("operator", createRule(parts[0].trim()), createRule(parts[1].trim()));
	        } else {
	            return new Node("operand", null, null);
	        }
	    }

	  
	    public boolean evaluateRule(Node root, Map<String, Object> data) {
	        if (root.type.equals("operand")) {
	            return evaluateOperand(root.value, data);  
	        }

	        boolean leftEval = evaluateRule(root.left, data);
	        boolean rightEval = evaluateRule(root.right, data);

	        if (root.value.equals("AND")) {
	            return leftEval && rightEval;
	        } else if (root.value.equals("OR")) {
	            return leftEval || rightEval;
	        }
	        return false; 
	    }

	    // Evaluate operand conditions (e.g., age > 30)
	    private boolean evaluateOperand(String operand, Map<String, Object> data) {
	        String[] parts;

	        if (operand.contains(">")) {
	            parts = operand.split(">");
	            String attribute = parts[0].trim();
	            int threshold = Integer.parseInt(parts[1].trim());

	            if (data.get(attribute) instanceof Integer) {
	                return (Integer) data.get(attribute) > threshold;
	            }

	        } else if (operand.contains("<")) {
	            parts = operand.split("<");
	            String attribute = parts[0].trim();
	            int threshold = Integer.parseInt(parts[1].trim());

	            if (data.get(attribute) instanceof Integer) {
	                return (Integer) data.get(attribute) < threshold;
	            }

	        } else if (operand.contains("=")) {
	            parts = operand.split("=");
	            String attribute = parts[0].trim();
	            String value = parts[1].trim();

	            if (data.get(attribute) instanceof String) {
	                return data.get(attribute).equals(value);
	            }
	        }

	        return false;  
	    }
	}



