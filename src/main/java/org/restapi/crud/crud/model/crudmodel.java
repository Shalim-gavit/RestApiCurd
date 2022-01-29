package org.restapi.crud.crud.model;

public class crudmodel 
{
		private int sno;
		private String sname;
		private String sdob;
		private String sdoj;

		public crudmodel()
		{

		}
		public crudmodel(int sno, String sname, String sdob, String sdoj) {
			super();
			this.sno = sno;
			this.sname = sname;
			this.sdob = sdob;
			this.sdoj = sdoj;
		}


		public int getSno() {
			return sno;
		}

		public void setSno(int sno) {
			this.sno = sno;
		}

		public String getSname() {
			return sname;
		}

		public void setSname(String sname) {
			this.sname = sname;
		}

		public String getSdob() {
			return sdob;
		}

		public void setSdob(String sdob) {
			this.sdob = sdob;
		}

		public String getSdoj() {
			return sdoj;
		}

		public void setSdoj(String sdoj) {
			this.sdoj = sdoj;
		}
}
