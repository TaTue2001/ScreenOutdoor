function fetchRoom(phongId) {
    if (!phongId) return renderRoom(null);
  
    $.ajax({
      url: `http://192.168.100.251:9000/api/phong/${phongId}`,
      method: 'GET',
      dataType: 'json',
    //   success: renderRoom,
    success: (data) => {
        renderRoom(data);
        renderBed(data);
    },
    error: () => {
      if (!isRetry) {
        alert('Lỗi khi tải dữ liệu phòng!');
      }

      // Tự động thử lại sau 30 giây (hoặc 60 giây nếu bạn muốn)
      setTimeout(() => {
        fetchRoom(phongId, true); // Lần gọi lại là retry, không hiện alert nữa
      }, 30000);
    }
  });
}
  
function loadDanhSachPhong() {
  $.ajax({
    url: 'http://192.168.100.251:9000/api/phong/phong',
    method: 'GET',
    dataType: 'json',
    success: function (data) {
      const select = $('#phong-select').empty().append('<option value="">-- chọn phòng --</option>');
      data.forEach(p => select.append(`<option value="${p.phongId}">${p.tenPhong}</option>`));

      const selectElement = $('#phong-select')[0];

      // Gắn sự kiện keydown một lần duy nhất
      if (!selectElement._scrollHandlerAttached) {
        selectElement._scrollHandlerAttached = true;
        selectElement.addEventListener('keydown', function (e) {
          if (e.key === 'ArrowDown' || e.key === 'ArrowUp') {
            setTimeout(() => {
              const selectedIndex = this.selectedIndex;
              const option = this.options[selectedIndex];
              if (option) {
                option.scrollIntoView({ behavior: 'smooth', block: 'nearest' });
              }
            }, 0); // Chờ sau khi thay đổi
          }
        });
      }
    },
    error: function (xhr, status, error) {
      retryCountPhong++;

      if (!isRetry) {
        alert('Không tải được danh sách phòng!');
      }
      console.warn(`Lỗi tải phòng (lần thử ${retryCountPhong}):`, error);

      if (retryCountPhong < maxRetryPhong) {
        setTimeout(() => {
          loadDanhSachPhong(true);
        }, 5000);
      } else {
        console.error('Không thể tải danh sách phòng sau nhiều lần thử.');
      }
    }
  });
}

  
async function loadComponent(targetSelector, url) {
    const response = await fetch(url);
    const html = await response.text();
    document.querySelector(targetSelector).innerHTML = html;
}

async function loadComponentTemplate(url) {
    const response = await fetch(url);
    return await response.text();
}

function autoRefreshData() {
    loadDanhSachPhong(); // Tải lại danh sách phòng
    const saved = localStorage.getItem('selectedPhongId');
    if (saved) {
        fetchRoom(saved); // Tải lại thông tin phòng đã chọn
    }
}