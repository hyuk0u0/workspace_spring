package kr.co.domain;

public class LoginDTO {

		private String userId;
		private String userPw;
		private String userName;
		private int grantsNum;
		
		public LoginDTO() {
			// TODO Auto-generated constructor stub
		}

		

		public LoginDTO(String userId, String userPw, String userName, int grantsNum) {
			super();
			this.userId = userId;
			this.userPw = userPw;
			this.userName = userName;
			this.grantsNum = grantsNum;
		}



		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getUserPw() {
			return userPw;
		}

		public void setUserPw(String userPw) {
			this.userPw = userPw;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}
		
		
		
		public int getGrantsNum() {
			return grantsNum;
		}



		public void setGrantsNum(int grantsNum) {
			this.grantsNum = grantsNum;
		}



		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((userId == null) ? 0 : userId.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LoginDTO other = (LoginDTO) obj;
			if (userId == null) {
				if (other.userId != null)
					return false;
			} else if (!userId.equals(other.userId))
				return false;
			return true;
		}



		@Override
		public String toString() {
			return "LoginDTO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", grantsNum="
					+ grantsNum + "]";
		}

		
		
		
}
