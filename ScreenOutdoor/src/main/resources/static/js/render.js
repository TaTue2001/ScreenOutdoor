function renderRoom(data) {
    
    const area = $('#content-area').empty();
    if (!data) return;
  
    $('#appbar-phong-name').text(data.tenPhong);

    if (!data) {
        $('#right-container').html('<p>Không có dữ liệu phòng.</p>');
        return;
    }

    const roomInfo = 
    `
    <div class="staff"> 
      <div class="right-title">PHỤ TRÁCH PHÒNG BỆNH </div>
      <div class="staff-info">
        <div class="staff-card">
            <div class="staff-title">Bác sĩ: </div>
            <div class="staff-name">${data.bacSiPhuTrach.ten_nhanvien}</div>
            <div class="staff-sdt">${data.bacSiPhuTrach.sdt}</div>
        </div>
        <div class="staff-card">
            <div class="staff-title">Điều dưỡng: </div>
            <div class="staff-name">${data.dieuDuongPhuTrach.ten_nhanvien}</div>
            <div class="staff-sdt">${data.dieuDuongPhuTrach.sdt}</div>
        </div>
      </div>
    </div>
    `;
    // `
    // <div class="staff-info">
    //     <div class="staff-card">
    //         <div class="staff-title">Bác sĩ: </div>
    //         <img class="staff-avatar" src="${data.bacSiPhuTrach.images}" alt="Bác sĩ" 
    //         onerror="this.onerror=null; this.src='assets/images/iconBS.png';">
    //         <div class="staff-name">${data.bacSiPhuTrach.ten_nhanvien}</div>
    //         <div class="staff-sdt">${data.bacSiPhuTrach.sdt}</div>
    //     </div>
    //     <div class="staff-card">
    //         <div class="staff-title">Điều dưỡng: </div>
    //         <img class="staff-avatar" src="${data.dieuDuongPhuTrach.images}" alt="Điều dưỡng"
    //         onerror="this.onerror=null; this.src='assets/images/iconDD.png';">
    //         <div class="staff-name">${data.dieuDuongPhuTrach.ten_nhanvien}</div>
    //         <div class="staff-sdt">${data.dieuDuongPhuTrach.sdt}</div>
    //     </div>
    // </div>
    // `;
    

    $('#right-container').html(roomInfo);
    // Thêm cả giường và nhân viên vào

}
  




function renderBed(data) {
    console.log(data); 
    const layoutContainer = document.getElementById('left-container');
    layoutContainer.innerHTML = ''; // Xóa nội dung cũ

    // Thêm tiêu đề
    const title = '<div class="left-title"><div class="bed-title">TÊN GIƯỜNG </div> <div class="patient-title">DANH SÁCH BỆNH NHÂN </div> </div>';
    layoutContainer.innerHTML += title;

    if (!data || !data.giuongList || data.giuongList.length === 0) {
        layoutContainer.innerHTML += '<p>Không có dữ liệu phòng.</p>';
        return;
    }

    // Số cột cố định là 1
    const cols = 1;

    // Cập nhật CSS Grid
    layoutContainer.style.display = 'grid';
    layoutContainer.style.gridTemplateColumns = `repeat(${cols}, 1fr)`;
    layoutContainer.style.gap = '0px'; // Khoảng cách giữa các item

    const bedCardsContainer = '<div class="bed-cards-container">';
    // Tạo danh sách giường
    const bedInfo = data.giuongList.map(bed => `
        <div class="bed-card">
            <div class="bed-name-container">
                <div class="bed-name">${bed.ten_giuongbenh || 'Chưa có thông tin'}</div>
            </div>
        
            <div class="patient-info">
                ${bed.patient ? `
            <div class="patient-name-gender">
            <div class="patient-name">${bed.patient.ten_benhnhan || 'Chưa có bệnh nhân'}</div>
            <div class="gender">
                <p>Giới tính: ${bed.patient.gioitinh || 'N/A'}</p>
            </div>
        </div>
        <div class="birth-ngaynhapvien">
            <div class="birth">
                <p>Ngày sinh: ${bed.patient.ngaysinh || 'N/A'}</p>
            </div>
            <div class="ngaynhapvien">Ngày nhập viện: ${bed.patient.ngaynhapvien || 'N/A'}</div>
        </div>
    ` : '<p>Chưa có bệnh nhân</p>'}
    </div>
        </div>
    `).join('');

     const bedCardsContainerEnd = '</div>';
    
    // Thêm danh sách giường vào layout
    layoutContainer.innerHTML +=bedCardsContainer+ bedInfo +bedCardsContainerEnd;
    
    const titleHeight = layoutContainer.querySelector('.left-title').clientHeight || 0;
    // Cập nhật chiều cao linh động cho item
    const layoutHeight = layoutContainer.clientHeight ; // Chiều cao của layout
    let itemHeight = 0; // Khởi tạo itemHeight
    if (data.giuongList.length > 0) {
        itemHeight = (layoutHeight *87) / (data.giuongList.length*100); 
    } else {
        itemHeight = layoutHeight; // Khi không có item, lấy chiều cao container
    }
    const itemWidth = layoutContainer.clientWidth-3 ; // Chiều rộng của mỗi item

    // Cập nhật chiều cao và chiều rộng cho các item
    document.querySelectorAll('.bed-card').forEach(item => {
        item.style.height = `${itemHeight}px`;
        item.style.width = `${itemWidth}px`;
    });
}