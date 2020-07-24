/**
 * 
 */
 
 		function getOriginalName(filename) {
			if (checkImage(filename)) {
				var idx = filename.indexOf("_");
				
				idx = filename.indexOf("_", idx + 1); <!-- 인덱스를 idx + 1 인놈에부터 찾아라 -->
				return filename.substring(idx + 1);
			} else {
				var idx = filename.indexOf("_");
				return filename.substring(idx + 1);
			}
		}

		function checkImage(filename) {
			var idx = filename.lastIndexOf(".");
			var format = filename.substring(idx+1).toUpperCase();
			if (format == 'PNG' || format == 'JPG' || format == 'JPEG' || format == 'GIF') {
				return true;
			} else {
				return false;
			}
		}
 
		function getImageLink(result) {
			if(checkImage(result)) {
				var idx = result.lastIndexOf(".");
				var pre = result.substring(0, 12);
				var suf = result.substring(14);
				var oriname = pre + suf;

				return oriname;
			} else {
				return result;
			}
		}