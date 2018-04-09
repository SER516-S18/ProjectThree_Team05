package project3.client.controller;

import project3.client.model.ExpressiveModel;

public class ClientExpression {

 ExpressiveModel expressiveModel;
 
 public ClientExpression() {
	 expressiveModel = new ExpressiveModel();
	 expressiveModel.setClench((float) 1.78);
 }

 public String getExpression() {
	 if(expressiveModel.getBlink()!=0) {
		 return "blink.gif";
	 }
	 else if(expressiveModel.getRightWlink()!=0) {
		 return "rightwink.gif";
	 }
	 else if(expressiveModel.getLeftWink()!=0) {
		 return "leftwink.gif";
	 }
	 else if(expressiveModel.getLookLeft()!=0) {
		 return "lookleft.gif";
	 }
	 else if(expressiveModel.getLookRight()!=0) {
		 return "lookright.gif";
	 }
	 else if(expressiveModel.getFurrowBrow()!=0) {
		 return "furrowbrow.gif";
	 }
	 else if(expressiveModel.getRaiseBrow()!=0) {
		 return "raisebrow.gif";
	 }
	 else if(expressiveModel.getSmile()!=0) {
		 return "smile.gif";
	 }
	 else if(expressiveModel.getClench()!=0) {
		 return "clench.gif";
	 }
	 else if(expressiveModel.getSmirkLeft()!=0) {
		 return "leftsmirk.gif";
	 }
	 else if(expressiveModel.getSmirkRight()!=0) {
		 return "rightsmirk";
	 }
	 else if(expressiveModel.getLaugh()!=0) {
		 return "laugh.gif";
	 }
	 else 
		 return null;
 }
}
