public class FertilizerAdvisorySystem_24RP00257 {
    public void processSamples(SoilAnalysis_24RP00257[] samples) {
        int balancedCount = 0;
        int deficientCount = 0;
        
        for (SoilAnalysis_24RP00257 sample : samples) {
            try {
                String recommendation = sample.calculateFertilizerNeeded();
                System.out.println("Farmer ID: " + sample.getFarmerId());
                System.out.println("District: " + sample.getDistrictName());
                System.out.println("Crop Type: " + sample.getCropType());
                System.out.println("Recommendation: " + recommendation);
                System.out.println("-------------------------------------");
                
                if (sample.isBalanced()) {
                    balancedCount++;
                } else if (recommendation.contains("DEFICIENT")) {
                    deficientCount++;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error processing sample for Farmer " + 
                    sample.getFarmerId() + ": " + e.getMessage());
                System.out.println("-------------------------------------");
            }
        }
        System.out.println("\nSUMMARY REPORT");
        System.out.println("Balanced samples: " + balancedCount);
        System.out.println("Deficient samples: " + deficientCount);
    }
    public static void main(String[] args) {
        SoilAnalysis_24RP00257[] samples = {
            new SoilAnalysis_24RP00257("F001", "kirehe", 50, 70, 80, "maize"),
            new SoilAnalysis_24RP00257("F002", "buugesera", 10, 45, 60, "rice"),
            new SoilAnalysis_24RP00257("F003", "nyagatare", 110, 90, 85, "beans"),
            new SoilAnalysis_24RP00257("F004", "gatsibo", -5, 40, 60, "maize"),
            new SoilAnalysis_24RP00257("F005", "huye", 15, 15, 18, "rice")
        };
        FertilizerAdvisorySystem_24RP00257 advisor = new FertilizerAdvisorySystem_24RP00257();
        advisor.processSamples(samples);
    }
}